from selenium import webdriver
import time
driver = webdriver.Firefox()
driver.get("http://www.baidu.com")
driver.find_element_by_id("kw").send_keys("qq")
driver.find_element_by_id("su").click()
time.sleep(2)
#将滚动条拖到底部
js = "var q=document.documentElement.scrollTop=10000"
driver.execute_script(js)
time.sleep(2)
#将滚动条拖到顶部
js = "var q=document.documentElement.scrollTop=10000"
driver.execute_script(js)
time.sleep(2)
driver.quit()