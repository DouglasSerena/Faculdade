<?php

function env(string $path)
{
  $envs = parse_ini_file($path);

  foreach ($envs as $key => $value) {
    $_ENV[$key] = $value;
  }
}
