package codec.types.field46.field2.types

import codec.FieldCodecs.LLVAR_N
import codec.types.WalletData4602XX
import scodec.Codec

case class ProviderAccountScore460203(score: String) extends WalletData4602XX

object ProviderAccountScore460203 {
  val codec: Codec[ProviderAccountScore460203] =
    LLVAR_N.as[ProviderAccountScore460203]
}
