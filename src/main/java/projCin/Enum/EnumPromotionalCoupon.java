package projCin.Enum;

public enum EnumPromotionalCoupon {
    CUPOM_UM("cupom com 10% de desconto", 0.9 ),
    CUPOM_DOIS("cupom com 30% de desconto", 0.7),
    CUPOM_TRES("cupom com 50% de desconto", 0.5);

    private final String nome;
    private final double desconto;

    private EnumPromotionalCoupon(String nome, double desconto) {
        this.nome = nome;
        this.desconto = desconto;
    }

    public String getNome() {
        return nome;
    }

    public double getDesconto() {
        return desconto;
    }
    
}

