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
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import uk.gov.hmrc.selenium.webdriver.Driver
import uk.gov.hmrc.ui.utils.DateUtil

import java.time.Duration

object ManageReportsPage extends BasePage with DateUtil {

  override val pageUrl: String = baseUrlForManualSubmission + s"/manage-reports-for-$reportingYear?fiId=TES683373304"

  val backLinkLocator: By = By.className("govuk-back-link")

  def checkPage(): this.type = {
    onPage(pageUrl)
//    checkH1("Submitted reports for Fifth FI for 2025")
    this
  }

  def clickBackLink(): this.type = {
    val wait     = new WebDriverWait(Driver.instance, Duration.ofSeconds(10))
    val backLink = wait.until(ExpectedConditions.elementToBeClickable(backLinkLocator))
    backLink.click()
    this
  }
}
