package codec.types.field48.types

import codec.FieldCodecs.{LLVAR_N, N}
import codec.types.field48.PrivateData48XX
import enumeratum.values.*
import scodec.codecs.*
import scodec.{Codec, TransformSyntax}

case class SchemeNetworkAuthentication4823(
    `type`: SchemeNetworkAuthentication4823.AuthenticationType
) extends PrivateData48XX

object SchemeNetworkAuthentication4823 {
  sealed abstract class AuthenticationType(val value: String) extends StringEnumEntry

  object AuthenticationType extends StringEnum[AuthenticationType] {
    val values = findValues

    case object CRYPTO_VALIDATED           extends AuthenticationType("00")
    case object CRYTO_AND_AMOUNT_VERIFIED  extends AuthenticationType("01")
    case object CHECK_BALANCE              extends AuthenticationType("02")
    case object CHECK_BALANCE_WITH_DS_ID   extends AuthenticationType("03")
    case object CONSIDER_AMOUNT            extends AuthenticationType("04")
    case object CONSIDER_AMOUNT_WITH_DS_ID extends AuthenticationType("05")
    case object ERROR_ON_DS_ID             extends AuthenticationType("06")
    case object INCORRECT_CRYPTO           extends AuthenticationType("07")
    case object SECURITY_DATA_ERROR        extends AuthenticationType("08")
    case object PROCESSING_NOT_POSSIBLE    extends AuthenticationType("09")
    case object TIMEOUT                    extends AuthenticationType("10")
    case object PROCESSING_ERROR           extends AuthenticationType("11")
    case object FORMAT_ERROR               extends AuthenticationType("12")
    case object MAC_KEY_VALIDATION_PASSED  extends AuthenticationType("13")
    case object MAC_KEY_VALIDATION_FAILED  extends AuthenticationType("14")
    case object UNKNOWN                    extends AuthenticationType("99")

    val mapping = AuthenticationType.valuesToEntriesMap.map(_.swap)
    val codec   = "AuthenticationType" | mappedEnum(N, mapping)
  }

  val codec: Codec[SchemeNetworkAuthentication4823] =
    LLVAR_N(AuthenticationType.codec).as[SchemeNetworkAuthentication4823]

}
