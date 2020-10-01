<!DOCTYPE html>
<html>

<head>
  <title>PAGE | Login</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
  <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
  <link rel="stylesheet" href="public/css/main.css">
</head>

<body>
  <div class="container-fluid">
    <div class="row">

      <div class="col-md-4"></div>
      <div class="col-md-4 p-5">
        <h1>Login system</h1>
        <form method=POST name="formulario" id="formulario">
          <div class="form-group">
            <label>User name</label>
            <input type="text" class="form-control" name="user" placeholder="User">
          </div>
          <div class="form-group">
            <label>password</label>
            <input type="password" class="form-control" name="password" placeholder="Password">
          </div>
          <input class="btn btn-primary" type="submit" name="submit" value="submit">
          <a class="btn btn-warning" href="/ULBRA_FACUDADE/?control=main&action=index">back</a>
        </form>
      </div>
      <div class="col-md-4"></div>
    </div>
    </<div>
  </div>

  <script src="public/js/message.js"></script>
  <script>
    <?php if (isset($_GET['message'])) : ?>
      message(<?= "'{$_REQUEST['message']}', '{$_GET['type']}'" ?>);
    <?php endif; ?>
  </script>
</body>

</html>