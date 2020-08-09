from selenium import webdriver
from selenium.webdriver.common.keys import Keys
import time,os
driver = webdriver.Firefox()
driver.get("http://demo.zentao.net/user-login-Lw==.html")
time.sleep(2)
driver.minimize_window()
driver.find_element_by_id("account").clear()
time.sleep(2)
driver.find_element_by_id("account").send_keys("demo")
time.sleep(2)
#tab的定位相当于清除了密码框的默认提示信息，等同于上面的clear
driver.find_element_by_id("account").send_keys(Keys.TAB)
time.sleep(2)
# #通过定位密码框，enter（回车）来代替登陆按钮
# driver.find_element_by_name("password").send_keys(Keys.ENTER)
# ...
#也可定位登陆按钮，通过enter（回车）代替click
driver.find_element_by_id("submit").send_keys(Keys.ENTER)
...
time.sleep(2)
driver.quit()