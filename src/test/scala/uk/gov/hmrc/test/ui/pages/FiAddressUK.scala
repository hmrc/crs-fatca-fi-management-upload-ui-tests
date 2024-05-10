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

object FiAddressUK extends BasePage {

  override val pageUrl: String = baseUrl + "/address-uk"
  val addressLine1: By         = By.id("addressLine1")
  val addressLine2: By         = By.id("addressLine2")
  val city: By         = By.id("addressLine3")
  val county: By         = By.id("addressLine4")
  val postCode: By         = By.id("postCode")
  val country: By         = By.id("country")

  def enterAddressManually(): Unit = {
    onPage(pageUrl)
    sendTextById(addressLine1, "addressLine1")
    sendTextById(addressLine2, "addressLine2")
    sendTextById(city, "Edinburgh")
    sendTextById(county, "Midlothian")
    sendTextById(postCode, "EH14 1TT")
    selectDropdownById(country).selectByVisibleText("Jersey")
    submitPageById()
  }
}
