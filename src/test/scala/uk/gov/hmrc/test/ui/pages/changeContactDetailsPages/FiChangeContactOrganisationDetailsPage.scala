/*
 * Copyright 2025 HM Revenue & Customs
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

package uk.gov.hmrc.test.ui.pages.changeContactDetailsPages

import org.openqa.selenium.By
import uk.gov.hmrc.test.ui.pages.BasePage

object FiChangeContactOrganisationDetailsPage extends BasePage {

  override val pageUrl: String        = changeContactBaseUrl + "/change-contact/organisation/details"
  val changeEmailLink: By             = By.xpath("//a[@class='govuk-link' and contains (@href,'change-email')]")
  val changeFirstContactNameLink: By  = By.xpath("//a[@class='govuk-link' and contains (@href,'change-contact-name')]")
  val changeSecondContactNameLink: By =
    By.xpath("//a[@class='govuk-link' and contains (@href,'change-have-second-contact')]")

  def checkPage(): Unit =
    onPage(pageUrl)

  def clickOnFirstContactNameChangeLink(): Unit = {
    onPage(pageUrl)
    clickOnByXpath(changeFirstContactNameLink)
  }

  def clickOnHaveSecondContactNameChangeLink(): Unit = {
    onPage(pageUrl)
    clickOnByXpath(changeSecondContactNameLink)
  }

  def checkPageHeader(h1: String): Unit = {
    onPage(pageUrl)
    checkH1(h1)
  }

  def confirmAndSend(): Unit = {
    onPage(pageUrl)
    submitPageById()
  }
}
