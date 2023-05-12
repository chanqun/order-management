package com.github.prgrms.products;

import com.github.prgrms.errors.NotFoundException;
import com.github.prgrms.utils.ApiUtils;
import com.github.prgrms.utils.ApiUtils.ApiResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.github.prgrms.utils.ApiUtils.success;
import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("api/products")
public class ProductRestController {

    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "{id}")
    public ApiResult<ProductDto> findById(@PathVariable Long id) {
        ProductDto productDto = productService.findById(id)
                .map(ProductDto::new)
                .orElseThrow(() -> new NotFoundException("Could not found product for " + id));

        return success(productDto);
    }

    // FIXME `요건 1` 정의에 맞게 응답 타입 수정이 필요합니다.
    @GetMapping
    public List<ProductDto> findAll() {
        return productService.findAll().stream()
                .map(ProductDto::new)
                .collect(toList());
    }

}