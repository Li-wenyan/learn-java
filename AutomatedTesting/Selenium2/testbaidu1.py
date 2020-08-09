#-*- coding: utf-8 -*-
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import Select
from selenium.common.exceptions import NoSuchElementException
from selenium.common.exceptions import NoAlertPresentException
import unittest, time, re,os
from ddt import ddt,data,file_data,unpack
@ddt
class Baidu1(unittest.TestCase):
    #test fixture，初始化环境
    def setUp(self):
        self.driver = webdriver.Firefox()
        self.driver.implicitly_wait(30)
        self.base_url = "http://www.baidu.com/"
        self.verificationErrors = []
        self.accept_next_alert = True
    #测试用例，必须以test开头
    #@unittest.skip("skipping")
    @data("王凯","敏敏子","蒋欣","佟大为")
    def test_baidusearch(self,value):
        driver = self.driver
        driver.get(self.base_url + "/")
        driver.find_element_by_id("kw").click()
        driver.find_element_by_id("kw").clear()
        driver.find_element_by_id("kw").send_keys(value)
        driver.find_element_by_id("su").click()
    @unittest.skip("skipping")
    def test_hao(self):
        driver = self.driver
        driver.get(self.base_url + "/")
        driver.find_element_by_link_text("hao123").click()
        try:
            self.assertEqual(u"hao123_上网从这里开始", driver.title)
            #self.assertTrue("123"=="1234",msg="Not true") #断言
        except:
            self.savescreenshot(driver,'hao.png')
    #判断element是否存在，可删除
    def is_element_present(self, how, what):
        try: self.driver.find_element(by=how, value=what)
        except NoSuchElementException as e: return False
        return True
    #判断alert是否存在，可删除
    def is_alert_present(self):
        try: self.driver.switch_to.alert
        except NoAlertPresentException as e: return False
        return True
    #关闭alert，可删除
    def close_alert_and_get_its_text(self):
        try:
            alert = self.driver.switch_to.alert
            alert_text = alert.text
            if self.accept_next_alert:
                alert.accept()
            else:
                alert.dismiss()
            return alert_text
        finally: self.accept_next_alert = True
    #test fixture，清除环境
    def tearDown(self):
        self.driver.quit()
        self.assertEqual([], self.verificationErrors)
    def savescreenshot(self, driver,file_name):
        if not os.path.exists('./image'):
            os.makedirs('./image')
        now = time.strftime("%Y%m%d-%H%M%S",time.localtime(time.time()))
        #截图保存
        driver.get_screenshot_as_file('./image/'+ now + '-' + file_name)

    if __name__ == "__main__":
        #执行用例
        unittest.main()