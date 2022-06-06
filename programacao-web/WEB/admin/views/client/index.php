<table class="table table-borderless">
  <thead>
    <tr>
      <th>#</th>
      <th>Avatar</th>
      <th>Name</th>
      <th>Email</th>
      <th>Phone</th>
      <th>Address</th>
      <th>Actions</th>
    </tr>
  </thead>
  <tbody>
    <?php if (!!$clients) : ?>
      <?php foreach ($clients as $client) : ?>
        <tr class="border-top">
          <th><?= $client['idClient'] ?></th>
          <td>
            <?php if (is_file("../tmp/uploads/clients/{$client['idClient']}.jpg")) : ?>
              <img class="img-fluid rounded-circle border" style="width: 75px;height: 50px;" src="<?= "/ULBRA_FACUDADE/tmp/uploads/clients/{$client['idClient']}.jpg" ?>" alt="">
            <?php else : ?>
              <img class="img-fluid rounded-circle border" style="width: 75px;height: 50px;" src="https://mail.katira.com.br/assets/img/sem-imagem-g.png" alt="">
            <?php endif; ?>
          </td>
          <td><?= $client['name'] ?></td>
          <td><?= $client['phone'] ?></td>
          <td><?= $client['email'] ?></td>
          <td><?= $client['address'] ?></td>
          <td>
            <a href="?control=client&action=update&id=<?= $client['idClient'] ?>" class="btn btn-warning">
              <i class="ri-pencil-line"></i>
            </a>
            <a href="?control=client&action=delete&id=<?= $client['idClient'] ?>" class="btn btn-danger">
              <i class="ri-delete-bin-2-line"></i>
            </a>
          </td>
        </tr>
      <?php endforeach; ?>
    <?php else : ?>
      <tr>
        <th><i class="ri-more-fill"></i></th>
        <th><i class="ri-more-fill"></i></th>
        <th><i class="ri-more-fill"></i></th>
        <th><i class="ri-more-fill"></i></th>
        <th><i class="ri-more-fill"></i></th>
        <th><i class="ri-more-fill"></i></th>
        <th><i class="ri-more-fill"></i></th>
      </tr>
    <?php endif; ?>
  </tbody>
</table>