package codec.types

import codec.FieldCodecs._
import codec.types.field46.field1.types._
import scodec.Codec
import scodec.codecs.{discriminated, list}

trait TokenData4601XX

// 46.1
case class TokenData4601(
    uniqueTokenId01: Option[UniqueId460101],
    tokenRequestorId02: Option[RequestorId460102],
    tokenTypeData03: Option[TypeData460103],
    tokenConfidenceLevel04: Option[ConfidenceLevel460104],
    tokenizationVisaScore05: Option[VisaScore460105],
    schemeNetworkDecision06: Option[SchemeNetworkDecision460106],
    tokenExpirationDate07: Option[ExpirationDate460107],
    tokenStatus08: Option[Status460108],
    activationResultVerification09: Option[ActivationResultVerification460109],
    activationNbAttempts10: Option[ActivationNbAttempts460110],
    messageReasonCode11: Option[MessageReasonCode460111],
    walletProvisionedToken12: Option[WalletProvisionedToken460112]
) extends WalletInfos46XX {
  override def toString: String = {
    List
      .concat(
        this.uniqueTokenId01,
        this.tokenRequestorId02,
        this.tokenTypeData03,
        this.tokenConfidenceLevel04,
        this.tokenizationVisaScore05,
        this.schemeNetworkDecision06,
        this.tokenExpirationDate07,
        this.tokenStatus08,
        this.activationResultVerification09,
        this.activationNbAttempts10,
        this.messageReasonCode11,
        this.walletProvisionedToken12
      )
      .mkString(", ")
  }
}

object TokenData4601 {
  private val subFieldsCodec: Codec[TokenData4601XX] =
    discriminated[TokenData4601XX]
      .by(N(2))
      .typecase("01", UniqueId460101.codec)
      .typecase("02", RequestorId460102.codec)
      .typecase("03", TypeData460103.codec)
      .typecase("04", ConfidenceLevel460104.codec)
      .typecase("05", VisaScore460105.codec)
      .typecase("06", SchemeNetworkDecision460106.codec)
      .typecase("07", ExpirationDate460107.codec)
      .typecase("08", Status460108.codec)
      .typecase("09", ActivationResultVerification460109.codec)
      .typecase("10", ActivationNbAttempts460110.codec)
      .typecase("11", MessageReasonCode460111.codec)
      .typecase("12", WalletProvisionedToken460112.codec)

  val codec: Codec[TokenData4601] =
    LLVAR(list(subFieldsCodec))
      .xmap(
        fields => {
          val field01 = fields.collectFirst({ case t: UniqueId460101 => t })
          val field02 = fields.collectFirst { case t: RequestorId460102 => t }
          val field03 = fields.collectFirst { case t: TypeData460103 => t }
          val field04 = fields.collectFirst { case t: ConfidenceLevel460104 =>
            t
          }
          val field05 = fields.collectFirst { case t: VisaScore460105 =>
            t
          }
          val field06 = fields.collectFirst {
            case t: SchemeNetworkDecision460106 => t
          }
          val field07 = fields.collectFirst { case t: ExpirationDate460107 =>
            t
          }
          val field08 = fields.collectFirst { case t: Status460108 => t }
          val field09 = fields.collectFirst {
            case t: ActivationResultVerification460109 => t
          }
          val field10 = fields.collectFirst {
            case t: ActivationNbAttempts460110 =>
              t
          }
          val field11 = fields.collectFirst { case t: MessageReasonCode460111 =>
            t
          }
          val field12 = fields.collectFirst {
            case t: WalletProvisionedToken460112 => t
          }
          TokenData4601(
            field01,
            field02,
            field03,
            field04,
            field05,
            field06,
            field07,
            field08,
            field09,
            field10,
            field11,
            field12
          )
        },
        td =>
          List.concat(
            td.uniqueTokenId01,
            td.tokenRequestorId02,
            td.tokenTypeData03,
            td.tokenConfidenceLevel04,
            td.tokenizationVisaScore05,
            td.schemeNetworkDecision06,
            td.tokenExpirationDate07,
            td.tokenStatus08,
            td.activationResultVerification09,
            td.activationNbAttempts10,
            td.messageReasonCode11,
            td.walletProvisionedToken12
          )
      )
}
