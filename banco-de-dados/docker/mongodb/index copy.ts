import { Collection, ObjectId } from "mongodb";

declare const db: Record<string, Collection>;
declare const ISODate: { new (date?: string): Date };

var metro_ref = new ObjectId();
var viagem_ref = new ObjectId();
var estacao_ref = new ObjectId();
var endereco_ref = new ObjectId();
var epassageiro_ref = new ObjectId();

db.metros.insertOne({
    _id: metro_ref,
    nome: "Super car",
    quantidada_maxima_pessoa: 20,
});
db.passageiros.insertOne({
    _id: epassageiro_ref,
    nome: "Douglas",
    cpf: "00099900099",
});
db.enderecos.insertOne({
    _id: endereco_ref,
    rua: "Patos carros",
    numero: "1234",
    bairro: "Zona nova",
    cep: "95555000",
});
db.estacoes.insertOne({
    _id: estacao_ref,
    nome: "viente",
    endereco_ref: endereco_ref,
});
db.viagens.insertOne({
    _id: viagem_ref,
    data_inicio: new ISODate(),
    data_fim: new ISODate(),
    status: "AGUARDANDO",
    metro_ref: metro_ref,
    estacao_ref: estacao_ref,
});
db.tickets.insertOne({
    valor: 23,
    data_compra: new ISODate(),
    utilizado: false,
    epassageiro_ref: epassageiro_ref,
    viagem_ref: viagem_ref,
});

db.metros.deleteOne({ _id: db.metros.findOne()._id });
db.passageiros.deleteOne({ _id: db.passageiros.findOne()._id });
db.enderecos.deleteOne({ _id: db.enderecos.findOne()._id });
db.estacoes.deleteOne({ _id: db.estacoes.findOne()._id });
db.viagens.deleteOne({ _id: db.viagens.findOne()._id });
db.tickets.deleteOne({ _id: db.tickets.findOne()._id });

db.tickets.findOne({ utilizado: false });
db.viagens.findOne({ status: "AGUARDANDO" });

db.estacoes
    .aggregate([
        {
            $lookup: {
                from: "enderecos",
                localField: "endereco_ref",
                foreignField: "_id",
                as: "enderecos",
            },
        },
        { $unwind: "$enderecos" },
    ])
    .pretty();
