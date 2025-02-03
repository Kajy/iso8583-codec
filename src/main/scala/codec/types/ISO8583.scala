package codec.types

import codec.BitMap.Fields
import codec.MessageType
import codec.types.field22.ReadingMode22
import codec.types.field25.POSConditionCode25
import codec.types.field3.ProcessingCode03
import codec.types.field39.ResponseCode39
import codec.types.field43.AcceptorInfos43
import codec.types.field44.AdviceDetail44
import codec.types.field47.AdditionalData47
import codec.types.field48.PrivateData48
import codec.types.field49.TransactionCurrency49
import codec.types.field51.BillingCurrency51
import codec.types.field53.SecurityInformation53
import codec.types.field54.AdditionalAmounts54
import codec.types.field55.ChipData55
import codec.types.field64.MacAuthentificationData64
import codec.types.field90.OriginalDataElements90
import codec.types.field95.ReplacementAmount95

import java.time.format.DateTimeFormatter
import java.time.{ LocalTime, MonthDay, YearMonth }

case class ISO8583(
    msgType: MessageType,
    fields: Fields,
    pan: Option[String],
    `type`: Option[ProcessingCode03],
    originalAmount: Option[String],
    amount: Option[String],
    time: Option[String],
    conversionRate: Option[String],
    auditNb: Option[String],
    localTime: Option[LocalTime],
    localDate: Option[MonthDay],
    cardExpirationDate: Option[YearMonth],
    reconciliationDate: Option[MonthDay],
    mcc: Option[String],
    readingMode: Option[ReadingMode22],
    panSequenceNumber: Option[String],
    posConditionCode: Option[POSConditionCode25],
    acquiringId: Option[String],
    retrievalRefNb: Option[String],
    authorizationNb: Option[String],
    responseCode: Option[ResponseCode39],
    terminalId: Option[String],
    acceptorId: Option[String],
    acceptorNameAddress: Option[AcceptorInfos43],
    adviceAdditionalData: Option[AdviceDetail44],
    walletDataInfos: Option[WalletInfos46],
    additionalData: Option[AdditionalData47],
    privateData: Option[PrivateData48],
    transactionCurrency: Option[TransactionCurrency49],
    billingCurrency: Option[BillingCurrency51],
    securityInformation: Option[SecurityInformation53],
    additionalAmounts: Option[AdditionalAmounts54],
    chipData: Option[ChipData55],
    macAuthentificationData64: Option[MacAuthentificationData64],
    originalDataElements90: Option[OriginalDataElements90],
    replacementAmount95: Option[ReplacementAmount95],
    macAuthentificationData128: Option[MacAuthentificationData64]
) {

  private val localDateFormatter = DateTimeFormatter.ofPattern("MM/dd")

  override def toString: String =
    f"""
       |FIELDS : ${fields.filter(_._2).keys.toList.sorted}
       |MSG TYPE: $msgType
       |PAN: $pan
       |TYPE: ${`type`}
       |ORIGINAL AMOUNT: $originalAmount
       |AMOUNT: $amount
       |TIME: $time
       |CONVERSION RATE: $conversionRate
       |AUDIT NB: $auditNb
       |LOCAL TIME: $localTime
       |LOCAL DATE: ${localDate.map(_.format(localDateFormatter))}
       |CARD EXPIRATION DATE: $cardExpirationDate
       |RECONCILIATION DATE: $reconciliationDate
       |MCC: $mcc
       |READING MODE: $readingMode
       |PAN SEQUENCE NB: $panSequenceNumber
       |POS CONDITION CODE: $posConditionCode
       |ACQUIRING ID: $acquiringId
       |RETRIEVAL REFERENCE NB: $retrievalRefNb
       |AUTHORIZATION NB: $authorizationNb
       |RESPONSE CODE: $responseCode
       |TERMINAL ID: $terminalId
       |ACCEPTOR ID: $acceptorId
       |ACCEPTOR NAME AND ADDRESS: $acceptorNameAddress
       |ADVICE DETAILS: $adviceAdditionalData
       |WALLET DATA INFO: $walletDataInfos
       |ADDITIONAL DATA: $additionalData
       |PRIVATE DATA: $privateData
       |TRANSACTION CURRENCY: $transactionCurrency
       |BILLING CURRENCY: $billingCurrency
       |SECURITY INFORMATION: $securityInformation
       |ADDITIONAL AMOUNTS: $additionalAmounts
       |CHIP DATA: $chipData
       |MAC AUTH DATA: $macAuthentificationData64
       |ORIGINAL DATA ELEMENTS: $originalDataElements90
       |REPLACEMENT AMOUNT: $replacementAmount95
       |""".stripMargin

}
