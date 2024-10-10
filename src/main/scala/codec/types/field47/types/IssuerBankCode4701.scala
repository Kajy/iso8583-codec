package codec.types.field47.types

import codec.FieldCodecs.LLVAR_N
import codec.types.field47.AdditionalData47XX
import scodec.Codec

case class IssuerBankCode4701(code: String) extends AdditionalData47XX

object IssuerBankCode4701 {
  val codec: Codec[IssuerBankCode4701] = LLVAR_N.as[IssuerBankCode4701]
}
