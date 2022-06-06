<?php

class FileModel
{
  function upload($photo, $name, $path = 'tmp/uploads')
  {
    if (isset($photo)) {
      $photo_temp = $photo["tmp_name"];    //pega o caminho temporário do arquivo
      $photo_name = $photo["name"];        //pega o nome

      $extension = pathinfo($photo_name, PATHINFO_EXTENSION); // str_replace('.','',strrchr(, '.')); //strtolower(end(explode('.', $photo_name))); //seleciona a extenção da imagem
      $max_width = 600; //define largura máxima
      $max_height = 600; //define altura míxima

      // Carrega a imagem 
      $img = null;

      //Transforma a imagem em JPG
      if ($extension == 'jpg' || $extension == 'jpeg') {
        $img = imagecreatefromjpeg($photo_temp);
      } else if ($extension == 'png') {
        $img = imagecreatefrompng($photo_temp);
      } else if ($extension == 'gif') {
        $img = imagecreatefromgif($photo_temp);
      } else
        $img = imagecreatefromjpeg($photo_temp);

      // Se a imagem foi carregada com sucesso, testa o tamanho da mesma
      if ($img) {
        // Pega o tamanho da imagem e calcula proporção de resize 
        $width  = imagesx($img);
        $height = imagesy($img);
        $scale  = min($max_width / $width, $max_height / $height);
        // Se a imagem é maior que o permitido, encolhe ela! 
        if ($scale < 1) {
          $new_width = floor($scale * $width);
          $new_height = floor($scale * $height);
          // Cria uma imagem temporária 
          $tmp_img = imagecreatetruecolor($new_width, $new_height);
          // Copia e resize a imagem velha na nova     
          imagecopyresampled(
            $tmp_img,
            $img,
            0,
            0,
            0,
            0,
            $new_width,
            $new_height,
            $width,
            $height
          );
          imagedestroy($img);
          $img = $tmp_img;
        }
      }

      //cria imagem no diretório @imagejpeg($img,"diretorio/".$id_noticia) se já tiver com este nome vai substituir
      $localFile = "{$path}/{$name}.jpg";
      imagejpeg($img, $localFile);
      return true;
    }
    return false;
  }

  public function remove(string $name, $path = '/ULBRA_FACUDADE/tmp/uploads')
  {
    $path_file = "{$path}/{$name}.jpg";
    if (!file_exists($path_file)) return false;
    unlink($path_file);
    return true;
  }
}
