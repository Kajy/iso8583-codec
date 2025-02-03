package codec

import codec.FieldCodecs.*
import codec.types.*
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
import scodec.codecs.*

import java.time.*

object ISO8583Definition {

  val PAN              = "PAN" | LLVAR_AN
  val TYPE             = "ProcessingCode" | ProcessingCode03.codec
  val ORIGINAL_AMOUNT  = "Original Amount" | N(12)
  val AMOUNT           = "Amount" | N(12)
  val TIME             = "Time" | N(10)
  val CONVERSTION_RATE = "Conversion rate" | N(8)
  val AUDIT_NB         = "Audit number" | N(6)

  val LOCAL_TIME = "Local time" | N(6).xmap(
    LocalTime.parse(_, localTimeFormatter),
    (t: LocalTime) => t.format(localTimeFormatter)
  )

  val LOCAL_DATE = "Local date" | N(4).xmap(
    MonthDay.parse(_, localDateFormatter),
    (t: MonthDay) => t.format(localDateFormatter)
  )

  val CARD_EXPIRATION_DATE = "Card expiration date" | N(4).xmap(
    YearMonth.parse(_, yearMonthFormatter),
    (t: YearMonth) => t.format(yearMonthFormatter)
  )

  val RECONCILIATION_DATE    = "Reconciliation date" | LOCAL_DATE
  val MCC                    = "MCC" | N(4)
  val READING_MODE           = "Reading mode" | ReadingMode22.codec
  val PAN_SEQUENCE_NB        = "Pan sequence number" | N(4)
  val POS_CONDITION_CODE     = "POS condition code" | POSConditionCode25.codec
  val ACQUIRING_ID           = "Acquiring ID" | LLVAR_N
  val RETRIEVAL_REF_NB       = "Retrieval Reference Number" | AN(12)
  val AUTHORIZATION_NB       = "Authorization Number" | AN(6)
  val RESPONSE_CODE          = "Response Code" | ResponseCode39.codec
  val TERMINAL_ID            = "Terminal ID" | ANS(8)
  val ACCEPTOR_ID            = "Acceptor ID" | ANS(15)
  val ACCEPTOR_NAME_ADDR     = "Acceptor name and address" | AcceptorInfos43.codec
  val ADVICE_ADD_DATA        = "Advice additional data" | AdviceDetail44.codec
  val WALLET_DATA_INFOS      = "Wallet data infos" | WalletInfos46.codec
  val ADDITIONAL_DATA        = "Additional data" | AdditionalData47.codec
  val PRIVATE_DATA           = "Private data" | PrivateData48.codec
  val TRANSACTION_CURRENCY   = "Transaction currency" | TransactionCurrency49.codec
  val BILLING_CURRENCY       = "Billing currency" | BillingCurrency51.codec
  val SECURITY_INFORMATION   = "Security information" | SecurityInformation53.codec
  val ADDITIONAL_AMOUNTS     = "Additional amounts" | AdditionalAmounts54.codec
  val CHIP_DATA              = "Chip data" | ChipData55.codec
  val MAC_AUTH_DATA          = "Mac authentification data" | MacAuthentificationData64.codec
  val ORIGINAL_DATA_ELEMENTS = "Original Data Elements" | OriginalDataElements90.codec
  val REPLACEMENT_AMOUNT       = "Replacement amount" | ReplacementAmount95.codec
  val MAC_AUTH_DATA_2       = "Replacement amount" | MacAuthentificationData64.codec
}
