from selenium import webdriver
from selenium.webdriver.common.keys import Keys
import time
driver = webdriver.Firefox()
driver.get("http://www.baidu.com")
driver.find_element_by_id("kw").send_keys("西安")
time.sleep(2)
#ctrl+a 全选输入框内容
driver.find_element_by_id("kw").send_keys(Keys.CONTROL,'a')
time.sleep(2)
#ctrl+x剪切输入框内容
driver.find_element_by_id("kw").send_keys(Keys.CONTROL,'x')
time.sleep(2)

driver.find_element_by_id("kw").send_keys("百度")
driver.find_element_by_id("su").click()
time.sleep(2)
driver.quit()
