from selenium import webdriver
import os,time
driver = webdriver.Firefox()
file_path = 'file:///'+os.path.abspath('upload.html')
driver.get(file_path)
#定位上传按钮，添加本地文件
driver.find_element_by_tag_name('input').send_keys('C:\\Users\\李文艳\\Desktop\\图片\\11.jpg')
time.sleep(2)
driver.quit()