package codec.types.field47

import codec.FieldCodecs.{LLVAR, N}
import codec.types.field47.types.IssuerBankCode4701
import scodec.Codec
import scodec.codecs.*

trait AdditionalData47XX

case class AdditionalData47(issuerBankCode01: Option[IssuerBankCode4701])

object AdditionalData47 {

  private val subFieldCodec =
    discriminated[AdditionalData47XX]
      .by(N(2))
      .typecase("01", "IssuerBankCode01" | IssuerBankCode4701.codec)

  val codec: Codec[AdditionalData47] = LLVAR(list(subFieldCodec).xmap(
    fields =>
      AdditionalData47(
        fields.collectFirst { case t: IssuerBankCode4701 => t }
      ),
    ad => List.concat(ad.issuerBankCode01)
  ))

}
