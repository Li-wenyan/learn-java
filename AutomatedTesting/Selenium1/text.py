from selenium import webdriver
import time
driver = webdriver.Firefox()
driver.get("http://www.baidu.com")
time.sleep(2)
# id = cp 元素的文本信息
data = driver.find_element_by_link_text("关于百度").text
print(data)
time.sleep(2)
driver.quit()
