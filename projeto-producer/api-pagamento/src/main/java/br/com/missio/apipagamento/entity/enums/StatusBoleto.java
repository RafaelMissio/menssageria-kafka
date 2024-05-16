package br.com.missio.apipagamento.entity.enums;

public enum StatusBoleto {

    INICIALIZADO,
    VALIDADO,
    ERRO_VALIDACAO,
    PAGO,
    ERRO_PAGAMENTO,
    CANCELADO
}
