
class Solution {
    Product convertProductDTOToProduct(ProductDTO dto) {
        //your code
        Product prod = new Product(dto.getId(), dto.getModel(), dto.getPrice(), "", "SuperVendor");
        return prod;
    }
}

/*,
                LocalDate.of(2023, 1, 15),
                "SuperVendor"*/