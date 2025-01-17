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

object FiIdentificationNumbers extends BasePage {

  override val pageUrl: String = baseUrl + "/identification-numbers"
  val selectUTR: By            = By.id("value_0")
  val selectCRN: By            = By.id("value_1")
  val selectURN: By            = By.id("value_2")

  def selectUTRYes(): Unit = {
    onPage(pageUrl)
    clickOnById(selectUTR)
    submitPageById()
  }

  def selectCRNYes(): Unit = {
    onPage(pageUrl)
    clickOnById(selectCRN)
    submitPageById()
  }

  def selectUTRandCRNYes(): Unit = {
    onPage(pageUrl)
    clickOnById(selectUTR)
    clickOnById(selectCRN)
    submitPageById()
  }

  def selectURNYes(): Unit = {
    onPage(pageUrl)
    clickOnById(selectURN)
    submitPageById()
  }
}
