from selenium import webdriver
import time
driver = webdriver.Firefox()
driver.get("http:/www.baidu.com")
time.sleep(2)
driver.find_element_by_id("kw").send_keys("风扇")
time.sleep(2)
driver.find_element_by_id("kw").clear()
driver.find_element_by_id("kw").send_keys("杯子")
time.sleep(2)
#通过submit来操作
driver.find_element_by_id("su").submit()
time.sleep(3)
driver.quit()