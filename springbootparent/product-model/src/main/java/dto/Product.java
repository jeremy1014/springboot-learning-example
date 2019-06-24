package dto;

import lombok.Data;

/**
 * 商品信息DTO对象
 *
 * @author CD826(CD826Dong @ gamil.com)
 * @since 1.0.0
 */
@Data
public class Product {
    private static final long serialVersionUID = 1L;

    // ========================================================================
    // fields =================================================================
    private String itemCode;                                    // 产品货号
    private String name;                                        // 产品名称
    private String bandName;                                    // 产品品牌名称
    private int price;                                          // 产品价格(分)

    // ========================================================================
    // constructor ============================================================
    public Product() {
    }

    public Product(String itemCode, String name, String bandName, int price) {
        this.itemCode = itemCode;
        this.name = name;
        this.bandName = bandName;
        this.price = price;
    }

}
