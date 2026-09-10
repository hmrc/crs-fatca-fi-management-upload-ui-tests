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

object UploadFilePage extends BasePage {

  override val pageUrl: String = baseUrlForFileUpload + "/upload-file"

  val backLink: By = By.id("back-link")

  def checkPage(): this.type = {
    onPage(pageUrl)
    checkH1("Upload an XML file for CRS or FATCA")
    this
  }

  def clickBackLink(): this.type = {
    onPage(pageUrl)
    click(backLink)
    this
  }
}
