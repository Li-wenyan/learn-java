#coding = utf-8
# from selenium import webdriver
# import time
# browser = webdriver.Firefox()
# browser.get("http://www.baidu.com")
# #############百度输入框的定位方式###########
# #id
# browser.find_element_by_id("kw").send_keys("谢娜")
# #name
# browser.find_element_by_name("wd").send_keys("张杰")
# #tag name
# #browser.find_element_by_tag_name("input").send_keys("元素")
# #class name
# browser.find_element_by_class_name("s_ipt").send_keys("物理")
# #CSS
# browser.find_element_by_css_selector("#kw").send_keys("大众")
# #xpath
# browser.find_element_by_xpath("//*[@id='kw']").send_keys("中国")
#
# ####################################
# browser.find_element_by_id("su").click()
# time.sleep(3)
# browser.quit()
#link text定位
# from selenium import webdriver
# browser = webdriver.Firefox()
# browser.get("http://www.baidu.com")
# browser.find_element_by_link_text("hao123").click()
# browser.quit()
#Partial link test定位
from selenium import webdriver
import time
browser = webdriver.Firefox()
browser.get("http://www.baidu.com")
browser.find_element_by_partial_link_text("hao").click()
time.sleep(3)
browser.quit()