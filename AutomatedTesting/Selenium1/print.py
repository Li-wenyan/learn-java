from selenium import webdriver
driver = webdriver.Firefox()
driver.get("http://www.baidu.com")
print(driver.title)
print(driver.current_url)
print(driver.current_window_handle)
driver.quit()