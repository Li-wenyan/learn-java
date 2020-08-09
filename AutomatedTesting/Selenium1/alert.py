from selenium import webdriver
from time import sleep
import os
dr = webdriver.Firefox()
file_path = 'file:///'+os.path.abspath('alert.html')
dr.get(file_path)
#点击链接弹出alert
dr.find_element_by_id('tooltip').click()
sleep(2)
# #接受警告信息
# alert = dr.switch_to.alert
# alert.accept()
# #得到文本信息打印
# alert = dr.switch_to.alert
# print(alert.text)
#取消对话框
alert = dr.switch_to.alert
alert.dismiss()
# #输入值 不能输入
# alert = dr.switch_to.alert
# alert.send_keys("wuli")
sleep(2)
dr.quit()