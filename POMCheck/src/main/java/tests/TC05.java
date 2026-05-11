package tests;

import core.BaseTest;
import core.FileUtil;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ImageGenerate;

public class TC05 extends BaseTest {

    @DataProvider(name = "imageGenData")
    public Object[][] getData() throws Exception {
        return FileUtil.ExcelUtil.getTableArray("src/test/resources/TestData.xlsx", "Sheet1");
    }

    @Test(dataProvider = "imageGenData")
    public void useImageSampleFromExcel(String prompt, String imagePath) {
        ImageGenerate imageGenerate = new ImageGenerate(getDriver());

        // 1. Nhập nội dung Prompt vào ô textarea (Describe the image...)
        By promptTextArea = By.xpath("//textarea[contains(@placeholder, 'Describe')]");
        imageGenerate.sendText(promptTextArea, prompt);

        // 2. Upload ảnh reference
        // Lưu ý: Với Selenium, để upload bạn gửi đường dẫn trực tiếp vào thẻ <input type='file'>
        // Thường nút "+" (trong ảnh image_973cb9.png) sẽ kích hoạt một input ẩn
        By uploadInput = By.xpath("//input[@type='file']");
        imageGenerate.sendText(uploadInput, imagePath);

        // 3. Đợi và nhấn Generate (ví dụ nút có text 'Generate')
        By generateBtn = By.xpath("//button[contains(., 'Generate')]");
        imageGenerate.clickJS(generateBtn);

        // 4. Đợi ảnh generate xong (sử dụng hàm waitForImageGenerating đã viết trước đó)
        imageGenerate.waitForImageGenerating(By.xpath("//span[contains(@class, 'loading')]"));
    }
}
