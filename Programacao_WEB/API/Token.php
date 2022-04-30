<?php

function base64Encode(string $datas): string
{
  return str_replace(
    ['+', '/', '='],
    ['-', '_', ''],
    base64_encode($datas)
  );
}

function cryptography(string $value): string
{
  return hash_hmac('sha256', $value, $_ENV['PASS_SECRET'], true);
}

class Token
{
  public static function create(string $name, bool $adm)
  {
    $header = base64Encode(
      json_encode([
        'alg' => 'HS256',
        'typ' => 'JWT'
      ])
    );
    $payload = base64Encode(
      json_encode([
        'iss' => 'localhost',
        'name' => $name,
        'adm' => $adm
      ])
    );

    $signature = base64Encode(
      cryptography("{$header}{$payload}")
    );

    return "{$header}.{$payload}.{$signature}";
  }

  public static function valid()
  {
    $headers = apache_request_headers();

    if (!array_key_exists('Authorization', $headers))
      return false;

    $token = $headers['Authorization'];
    $token = str_replace("Bearer ", "", $token);

    $part = explode(".", $token);

    $header = $part[0];
    $payload = $part[1];
    $signature = $part[2];
    // $payload = base64_decode($payload);

    $valid = base64Encode(
      cryptography("{$header}{$payload}")
    );

    return $valid == $signature;
  }
}
