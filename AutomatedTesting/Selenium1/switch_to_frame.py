from selenium import webdriver
import time
import os
br = webdriver.Firefox()
file_path = 'file:///'+os.path.abspath('frame.html')
br.get(file_path)
br.implicitly_wait(30)
#先找到ifrome1（id=f1）
br.switch_to.frame("f1")
#再找到其下面的ifrome2（id=f2）
br.switch_to.frame("f2")
br.find_element_by_id("kw").send_keys("英语")
br.find_element_by_id("su").click()
time.sleep(2)
br.quit()