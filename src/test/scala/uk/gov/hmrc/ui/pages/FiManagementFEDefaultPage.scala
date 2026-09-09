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

package uk.gov.hmrc.ui.pages

import org.openqa.selenium.By

object FiManagementFEDefaultPage extends BasePage {

  override val pageUrl: String               = baseUrl
  val addFinancialInstitutionLink: By        = By.id("add-financial-institution")
  val changeContactLink: By                  = By.linkText("Change your contact details")
  val changeContactLinkOrg: By               = By.linkText("Change the contact details for CRS and FATCA Company")
  val manageYourFinancialInstitutionsId: By  = By.id("your-financial-institutions")
  val uploadFileLink: By                     = By.id("upload-file")
  val viewResultsOfRecentSubmissionsLink: By = By.id("view-results-of-recent-submissions")

  def checkPage(): Unit =
    onPage(pageUrl)

  def clickAddFinancialInstitution(): Unit = {
    onPage(pageUrl)
    click(addFinancialInstitutionLink)
  }

  def clickChangeContactLink(): Unit = {
    onPage(pageUrl)
    click(changeContactLink)
  }

  def clickChangeContactLinkForOrganisation(): Unit = {
    onPage(pageUrl)
    click(changeContactLinkOrg)
  }

  def clickManageYourFinancialInstitutions(): Unit = {
    onPage(pageUrl)
    click(manageYourFinancialInstitutionsId)
  }

  def clickViewResultsOfRecentSubmissions(): this.type = {
    onPage(pageUrl)
    click(viewResultsOfRecentSubmissionsLink)
    this
  }

  def clickUploadFile(): this.type = {
    onPage(pageUrl)
    click(uploadFileLink)
    this
  }

}
