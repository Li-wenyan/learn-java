# from selenium import webdriver
# import time
# browser = webdriver.Firefox()
# browser.get("http://www.baidu.com")
# print("浏览器最大化")
# browser.minimize_window()
# time.sleep(2)
# browser.find_element_by_id("kw").send_keys("三国")
# browser.find_element_by_id("su").click()
# time.sleep(2)
# browser.quit()

from selenium import webdriver
import time
browser = webdriver.Firefox()
browser.get("http://www.baidu.com")
time.sleep(2)
#参数数字为像素点
print("设置浏览器宽480，高800")
browser.set_window_size(480,800)
time.sleep(2)
browser.quit()
