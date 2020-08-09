from selenium import webdriver
import time,os
import selenium.webdriver.support.ui as ui
dr = webdriver.Firefox()
file_path = 'file:///'+os.path.abspath('modal.html')
dr.get(file_path)
#打开对话框
dr.find_element_by_id('show_modal').click()
time.sleep(2)
#点击对话框中的链接
link = dr.find_element_by_id('myModal').find_element_by_id('click')
link.click()
time.sleep(2)
#关闭对话框
buttons = dr.find_element_by_class_name('modal-footer').find_elements_by_tag_name('button')
buttons[0].click()
time.sleep(2)
dr.quit()