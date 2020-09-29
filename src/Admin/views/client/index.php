<div class="table-responsive text-nowrap" style="position: relative!important;right: 0!important;left:0!important;">
  <table class="table table-striped ">
    <thead>
      <tr>
        <th>#</th>
        <th>Nome</th>
        <th>Email</th>
        <th>Telefone</th>
        <th>address</th>
        <th>delete</th>
        <th>update</th>
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
          <td>
            <a href="/ULBRA_FACUDADE/admin/client/delete/<?= $client['idClient'] ?>" class="btn btn-danger rounded-circle">
              <i class="fa fa-trash "></i>
            </a>
          </td>
          <td>
            <a href="/ULBRA_FACUDADE/admin/client/update/<?= $client['idClient'] ?>" class="btn btn-warning rounded-circle">
              <i class="fa fa-edit"></i>
            </a>
          </td>
        </tr>
      <?php endforeach; ?>

    </tbody>
  </table>
</div>