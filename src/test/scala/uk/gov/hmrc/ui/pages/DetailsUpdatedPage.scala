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

package uk.gov.hmrc.ui.pages

import org.openqa.selenium.By
import uk.gov.hmrc.ui.utils.DateUtil

object DetailsUpdatedPage extends BasePage with DateUtil {

  override val pageUrl: String = baseUrl + "/details-updated"

  val backToManageFinancialInstitutionsLink: By = By.linkText("Back to manage your financial institutions")
  val backToManageReportsLink: By               = By.linkText("Back to manage your CRS and FATCA reports")

  def checkPage(): this.type = {
    onPage(pageUrl)
    checkH1("Details updated for Financial Institution One")
    this
  }

  def clickBackToManageFinancialInstitutions(): this.type = {
    onPage(pageUrl)
    click(backToManageFinancialInstitutionsLink)
    this
  }

  def clickBackToManageReports(): this.type = {
    onPage(pageUrl)
    click(backToManageReportsLink)
    this
  }

}
