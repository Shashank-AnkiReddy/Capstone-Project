from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from utils.decorators import log_test


@log_test
def test_wordpress_theme_search(driver):

    wait = WebDriverWait(driver, 20)

    # 1. Open WordPress site and verify title
    driver.get("https://wordpress.org/")
    assert "WordPress.org" in driver.title

    # 2. Mouse hover on "Extend"
    extend_menu = wait.until(
        EC.visibility_of_element_located((By.XPATH, "//span[text()='Extend']"))
    )
    ActionChains(driver).move_to_element(extend_menu).perform()

    # Click on "Themes"
    themes_option = wait.until(
        EC.element_to_be_clickable((By.XPATH, "//span[text()='Themes']"))
    )
    themes_option.click()

    # 3. Search for a theme
    search_box = wait.until(
        EC.visibility_of_element_located((By.ID, "wp-block-search__input-8"))
    )
    search_box.clear()
    search_box.send_keys("Astra")
    search_box.send_keys(Keys.ENTER)

    driver.execute_script("window.scrollBy(0, 100);")

    # Take screenshot (optional)
    driver.save_screenshot("theme_search_result.png")

    # 4. Verify theme name is displayed
    assert "Astra" in driver.page_source
