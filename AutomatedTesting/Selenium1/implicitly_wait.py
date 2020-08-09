from selenium import webdriver
import time
browser = webdriver.Firefox()
browser.get("http://www.baidu.com")
browser.implicitly_wait(30)
browser.find_element_by_id("kw").send_keys("苏珊")
browser.find_element_by_id("su").click()
time.sleep(2)
browser.quit()