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
import uk.gov.hmrc.test.ui.pages.FiUtrPage.{FiUtrID, onPage, pageUrl, randomisedUtr, sendTextById, submitPageById}

object FiGiinPage extends BasePage {
  //TODO change URl when actual page is developed
  override val pageUrl: String = baseUrl + "/giin"

  val giin: By = By.id("value")

  def enterGiin(): Unit = {
    onPage(pageUrl)
    sendTextById(FiUtrID, "98096B.00000.LE.350")
    submitPageById()
  }

}
