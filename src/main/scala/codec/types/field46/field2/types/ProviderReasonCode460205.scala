package codec.types.field46.field2.types

import codec.FieldCodecs.{LLVAR_AN, LLVAR_ANS, LLVAR_N}
import codec.types.WalletData4602XX
import scodec.Codec

case class ProviderReasonCode460205(codes: List[String])
    extends WalletData4602XX

object ProviderReasonCode460205 {
  val codec: Codec[ProviderReasonCode460205] =
    LLVAR_ANS.xmap(
      s => ProviderReasonCode460205(s.grouped(2).toList),
      _.codes.mkString
    )
}
