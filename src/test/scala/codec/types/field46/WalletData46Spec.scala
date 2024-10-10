package codec.types.field46

import codec.FieldCodecs.LLVAR_ANS
import codec.ISO8583Definition.WALLET_DATA_INFOS
import codec.types.field46.field1.types.{
  ActivationResultVerification460109,
  MessageReasonCode460111,
  SchemeNetworkDecision460106,
  Status460108,
  TypeData460103
}
import codec.types.field46.field2.types.{
  ProviderRiskAssessment460201,
  XPayId460207
}
import codec.types.field46.field3.types.{
  OSType460304,
  StorageTechnology460315,
  TimezoneConfiguration460313,
  Type460303
}
import codec.types.field46.field4.`type`.{CVX2Result460404, PanSource460403}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.OptionValues
import org.scalatest.matchers.must.Matchers.convertToAnyMustWrapper
import scodec.bits.HexStringSyntax

import java.time.YearMonth

class WalletData46Spec extends AnyFlatSpec with OptionValues {
  "WalletInfo token data (46.01)" should "be decoded" in {
    val infoSize = hex"0043"
    val field01Size = hex"0141"
    val field0101 = hex"0103f1f2f3"
    val field0102 = hex"020c050110030273"
    val field0103 = hex"0302f0f3"
    val field0104 = hex"04024040"
    val field0105 = hex"050285"
    val field0106 = hex"0602f0f3"
    val field0107 = hex"07041912"
    val field0108 = hex"0802f0f2"
    val field0109 = hex"0902f0f3"
    val field0110 = hex"100202"
    val field0111 = hex"11043700"
    val field0112 = hex"1210f0f8f4f2f7f9f4f6f6f7f4f5f3f4f2f2"
    val tokenDataHex =
      (infoSize ++ field01Size ++ field0101 ++ field0102 ++ field0103 ++ field0104 ++ field0105 ++ field0106 ++ field0107 ++ field0108 ++ field0109 ++ field0110 ++ field0111 ++ field0112).bits

    val result = WALLET_DATA_INFOS.decode(tokenDataHex).toOption.value.value

    val result01 = result.tokenData01.value
    result01.uniqueTokenId01.value.id mustBe "123"
    result01.tokenRequestorId02.value.id mustBe "050110030273"
    result01.tokenTypeData03.value.`type` mustBe TypeData460103.Type.CLOUD
    result01.tokenConfidenceLevel04.value.value mustBe "  "
    result01.tokenizationVisaScore05.value.score mustBe "85"
    result01.schemeNetworkDecision06.value.decisionStatus mustBe SchemeNetworkDecision460106.DecisionStatus.OTP
    result01.tokenExpirationDate07.value.date mustBe YearMonth.of(2019, 12)
    result01.tokenStatus08.value.status mustBe Status460108.DecisionStatus.INACTIVE
    result01.activationResultVerification09.value.result mustBe ActivationResultVerification460109.VerificationStatus.FAILED
    result01.activationNbAttempts10.value.nb mustBe "02"
    result01.messageReasonCode11.value.code mustBe MessageReasonCode460111.ReasonCode.TOKEN_CREATED
    result01.walletProvisionedToken12.value.token mustBe "0842794667453422"

    val encodeResult = WALLET_DATA_INFOS.encode(result).toOption.value
    encodeResult.toHex mustBe tokenDataHex.toHex
  }

  "WalletInfo wallet data (46.02)" should "be decoded" in {
    val infoSize = hex"0025"
    val field02Size = hex"0223"
    val field0201 = hex"0102f0f2"
    val field0202 = hex"0203F1F2F3"
    val field0203 = hex"030205"
    val field0205 = hex"0506F0F3C1C7C1C8"
    val field0206 = hex"0603F1F2F3"
    val field0207 = hex"070201"
    val field0208 = hex"0805f0f2f1f8f9"
    val walletInfoHex =
      (infoSize ++ field02Size ++ field0201 ++ field0202 ++ field0203 ++ field0205 ++ field0206 ++ field0207 ++ field0208).bits

    val result = WALLET_DATA_INFOS.decode(walletInfoHex).toOption.value.value

    val field02 = result.walletData02.value

    field02.providerRiskAssessment01.value.decisionStatus mustBe ProviderRiskAssessment460201.Status.OTP
    field02.providerRiskAssessmentVersion02.value.version mustBe "123"
    field02.providerAccountScore03.value.score mustBe "05"
    field02.providerReasonCode05.value.codes mustBe List("03", "AG", "AH")
    field02.accountId06.value.id mustBe "123"
    field02.xPayId07.value.id mustBe XPayId460207.XPayId.APPLE_PAY
    field02.appPaymentInstanceId08.value.id mustBe "02189"

    val encodeResult = WALLET_DATA_INFOS.encode(result).toOption.value
    encodeResult.toHex mustBe walletInfoHex.toHex
  }

  "WalletInfo device data (46.03)" should "be decoded" in {
    val infoSize = hex"005d"
    val field03Size = hex"035b"
    val field0301 = hex"0103F1F2F3"
    val field0302 = hex"0203F1F2F3"
    val field0303 = hex"0302F0F8"
    val field0304 = hex"040202"
    val field0305 = hex"0503F1F2F3"
    val field0306 = hex"0603C5D5C7"
    val field0307 = hex"070cf8f04bf1f24bf4f14bf1f6f2"
    val field0308 = hex"0803F1F2F3"
    val field0309 = hex"090205"
    val field0310 = hex"1003F1F2F3"
    val field0311 = hex"1103F1F2F3"
    val field0312 = hex"1205E4E3C34EF3"
    val field0313 = hex"130201"
    val field0314 = hex"14100102030405060708"
    val field0315 = hex"1502F0F3"
    val field0316 = hex"1606404040404040"
    val deviceInfoHex =
      (infoSize ++ field03Size ++ field0301 ++ field0302 ++ field0303 ++ field0304 ++ field0305 ++ field0306 ++ field0307 ++ field0308 ++ field0309 ++ field0310 ++ field0311 ++ field0312 ++ field0313 ++ field0314 ++ field0315 ++ field0316).bits

    val result = WALLET_DATA_INFOS.decode(deviceInfoHex).toOption.value.value

    val field03 = result.deviceData03.value

    field03.serialNumber01.value.value mustBe "123"
    field03.name02.value.value mustBe "123"
    field03.type03.value.`type` mustBe Type460303.Type.CARD_MCD
    field03.osType04.value.`type` mustBe OSType460304.Type.IOS_VISA
    field03.osIdentifier05.value.value mustBe "123"
    field03.languageCode06.value.code mustBe "ENG"
    field03.ipAddress07.value.value mustBe "80.12.41.162"
    field03.location08.value.value mustBe "123"
    field03.deviceTrustScore09.value.value mustBe "05"
    field03.hardwareIdentifier10.value.value mustBe "123"
    field03.bluetoothMacAddress11.value.value mustBe "123"
    field03.deviceTimezone12.value.value mustBe "UTC+3"
    field03.timezoneConfiguration13.value.configBy mustBe TimezoneConfiguration460313.Configuration.BY_NETWORK
    field03.deviceNumber14.value.value mustBe "0102030405060708"
    field03.storageTechnology15.value.`type` mustBe StorageTechnology460315.TechnologyType.SERVER
    field03.lastDigits16.value.value mustBe "      "

    val encodeResult = WALLET_DATA_INFOS.encode(result).toOption.value
    encodeResult.toHex mustBe deviceInfoHex.toHex
  }

  "WalletInfo others data (46.04)" should "be decoded" in {
    val infoSize = hex"001b"
    val field04Size = hex"0419"
    val field0401 = hex"0103F1F2F3"
    val field0402 = hex"0203F1F2F3"
    val field0403 = hex"030201"
    val field0404 = hex"0401D4"
    val field0405 = hex"0503F1F2F3"
    val field0406 = hex"0602D2D1"
    val walletInfoHex =
      (infoSize ++ field04Size ++ field0401 ++ field0402 ++ field0403 ++ field0404 ++ field0405 ++ field0406).bits

    val result = WALLET_DATA_INFOS.decode(walletInfoHex).toOption.value.value

    val field04 = result.otherData04.value

    field04.productConfig01.value.value mustBe "123"
    field04.correlationId02.value.value mustBe "123"
    field04.panSource03.value.panSource mustBe PanSource460403.PanSource.CARD_ON_FILE
    field04.cvx2Result04.value.value mustBe CVX2Result460404.Result.VALID
    field04.activeTokenNb05.value.value mustBe "123"
    field04.holderName06.value.value mustBe "KJ"
    val encodeResult = WALLET_DATA_INFOS.encode(result).toOption.value
    encodeResult.toHex mustBe walletInfoHex.toHex
  }

}
