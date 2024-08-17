Pedido:

{
  "id": 1,
  "dataPedido": "2024-08-16T14:30:00",
  "status": "PENDENTE",
  "valorTotal": 150.75,
  "numeroMesa": 12
}


Item:

{
  "id": 1,
  "nome": "Pizza Margherita",
  "descricao": "Pizza com molho de tomate, queijo e manjericão.",
  "preco": 50.25
}


ItemPedido:

{
  "id": 1,
  "pedido": {
    "id": 1
  },
  "item": {
    "id": 1
  },
  "quantidade": 3,
  "precoUnitario": 50.25
}


exemplo de requisição para criar pedido:
{
    "dataPedido": "2024-08-16T14:30:00",
    "status": "PENDENTE",
    "valorTotal": 150.75,
    "numeroMesa": 12,
    "itens": [
        {
            "pedido": {
                "id": null
            },
            "item": {
                "id": 1
            },
            "quantidade": 3,
            "precoUnitario": 50.25
        },
        {
            "pedido": {
                "id": null
            },
            "item": {
                "id": 2
            },
            "quantidade": 2,
            "precoUnitario": 50.25
        }
    ]
}