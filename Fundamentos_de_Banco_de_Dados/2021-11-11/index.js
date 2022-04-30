const axios = require("axios");

function createSQL(table, data) {
  const keys = Object.keys(data[0]);
  const values = data.map((item) => {
    const values = Object.entries(item).map(([key, value]) => {
      if (key === "id") {
        return parseInt(value);
      }
      if (typeof value === "string") {
        return `'${value.replace("'", "")}'`;
      }

      return value;
    });

    return `(${values.join(",")})`;
  });

  return `INSERT INTO ${table} (${keys.join(",")}) VALUES ${values};`;
}

async function main() {
  // ------------------------ CIDADES ------------------------------ //
  // const cidades = await axios.get(
  //   "https://618ef5ed50e24d0017ce1500.mockapi.io/cidades"
  // );
  // console.log(createSQL("cidades", cidades.data));
  // ------------------------ MEDICOS ------------------------------ //
  // const medicos = await axios.get(
  //   "https://618ef5ed50e24d0017ce1500.mockapi.io/medicos"
  // );
  // console.log(createSQL("medicos", medicos.data));
  // ------------------------ PACIENTES ------------------------------ //
  // const pacientes = await axios.get(
  //   "https://618ef5ed50e24d0017ce1500.mockapi.io/pacientes"
  // );
  // console.log(createSQL("pacientes", pacientes.data));
  // ------------------------ CONSULTA ------------------------------ //
  const consultas = await axios.get(
    "https://618ef5ed50e24d0017ce1500.mockapi.io/consultas"
  );
  console.log(createSQL("consultas", consultas.data));
}

main();
