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

package uk.gov.hmrc.test.ui.specs

import uk.gov.hmrc.test.ui.pages._
import uk.gov.hmrc.test.ui.specs.tags._

class FiManagementSpec extends BaseSpec {

  Feature("Getting into the service") {

    Scenario(
      "Individual user enters service",
      FiManagementTests,
      ZapTests
    ) {

      Given("The user logs in as an individual")
      AuthLoginPage.loginAsBasic()

      When("The user hits the landing mpage then jumps to the first page built in the service")
      FiManagementFEDefaultPage.checkPage()
      FiManagementFEDefaultPage.navigateToNamePage()
      // TODO Temporarily added the following step to navigate to first page in the journey that exists - should be removed later
      FiNamePage.enterFiName()
      FiHaveUtrPage.fiHhaveUtrYes()
      FiUtrPage.enterFiUtr()
      FiFatcaReportsPage.fiFatcaReportsYes()

      // TODO Added last check to confirm submission of UTR page - should be removed later
      FiManagementFEDefaultPage.checkPage()
    }
  }
}
