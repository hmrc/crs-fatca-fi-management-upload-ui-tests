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

object FiManagementFEDefaultPage extends BasePage {

  override val pageUrl: String = baseUrl
  val addFILink: By            = By.id("add-financial-institution")
  val changeContactLink: By    = By.linkText("Change your contact details")
  val changeContactLinkOrg: By = By.linkText("Change the contact details for CRS and FATCA Company")
  val manageYourFinancialInstitutionsId: By = By.id("your-financial-institutions")
  def checkPage(): Unit        =
    onPage(pageUrl)

  def clickAddFILink(): Unit = {
    onPage(pageUrl)
    clickOnById(addFILink)
  }

  def clickChangeContactLink(): Unit = {
    onPage(pageUrl)
    clickOnById(changeContactLink)
  }

  def clickChangeContactLinkForOrganisation(): Unit = {
    onPage(pageUrl)
    clickOnById(changeContactLinkOrg)
  }

  def clickManageYourFinancialInstitutions(): Unit = {
    onPage(pageUrl)
    clickOnById(manageYourFinancialInstitutionsId)
  }
}
