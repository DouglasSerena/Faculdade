<div class="table-responsive text-nowrap" style="position: relative!important;right: 0!important;left:0!important;">
  <table class="table table-striped ">
    <thead>
      <tr>
        <th>#</th>
        <th>Nome</th>
        <th>Email</th>
        <th>Telefone</th>
        <th>address</th>
      </tr>
    </thead>
    <tbody>

      <?php foreach ($datas as $client) : ?>
        <tr>
          <td><?= $client['idClient'] ?></td>
          <td><?= $client['name'] ?></td>
          <td><?= $client['email'] ?></td>
          <td><?= $client['phone'] ?></td>
          <td><?= $client['address'] ?></td>
        </tr>
      <?php endforeach; ?>

    </tbody>
  </table>
</div>