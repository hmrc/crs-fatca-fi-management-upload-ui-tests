/*
 * Copyright 2023 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.By

object FiYourFisPage extends BasePage {

  override val pageUrl: String         = baseUrl + "/your-fis"
  val firstFiRemoveLink: By            = By.xpath("//a[@class='govuk-link' and contains (@href,'/remove/user-access/683373339')]")
  val registeredBusinessTag: By        = By.cssSelector("strong[class='govuk-tag']")
  val changeRegisteredBusinessLink: By = By.cssSelector(
    "div:nth-child(1) > dd:nth-child(2) > ul:nth-child(1) > li:nth-child(1) > a:nth-child(1) > span:nth-child(1)"
  )

  def checkPage(): Unit =
    onPage(pageUrl)

  def clickOnRemoveFirstFI(): Unit = {
    onPage(pageUrl)
    clickOnById(firstFiRemoveLink)
  }

  def checkSuccessBannerDisplayed(): Unit = {
    onPage(pageUrl)
    checkBanner()
  }

  def checkAndUpdateRegisteredBusinessStatus(): Unit = {
    onPage(pageUrl)
    if (driver.findElements(registeredBusinessTag).size() > 0) {
      clickOnById(changeRegisteredBusinessLink)
    } else {
      throw new IllegalStateException("No Registered Business exists for the FI user. Cannot proceed with changes.")
    }
  }

}
