package codec

import scodec.Codec
import scodec.bits.{BitVector, ByteVector}
import scodec.codecs._

import java.time.format.DateTimeFormatter

object FieldCodecs {

  val yearMonthFormatter = DateTimeFormatter.ofPattern("yyMM")
  val localTimeFormatter = DateTimeFormatter.ofPattern("HHmmss")
  val localDateFormatter = DateTimeFormatter.ofPattern("MMdd")

  val N: Codec[String] = bits.xmap(
    _.toBase16,
    BitVector.fromValidHex(_)
  )
  val AN: Codec[String] = bytes.xmap(
    e => new String(e.toArray, "Cp1047"),
    d => ByteVector(d.getBytes("Cp1047"))
  )
  val ANS: Codec[String] = bytes.xmap(
    e => new String(e.toArray, "Cp1047"),
    d => ByteVector(d.getBytes("Cp1047"))
  )
  val LLVAR_N: Codec[String] = variableSizeBytes(int8.xmap(_ / 2, _ * 2), N)
  val LLVAR_AN: Codec[String] = variableSizeBytes(int8, AN)
  val LLLVAR_AN: Codec[String] = variableSizeBytes(int16, AN)
  val LLVAR_ANS: Codec[String] = variableSizeBytes(int8, ANS)

  def AN(size: Int): Codec[String] = fixedSizeBytes(size, AN)
  def ANS(size: Int): Codec[String] = fixedSizeBytes(size, AN)
  def N(size: Int): Codec[String] = fixedSizeBits(size * 4, N) // Unit quartet
  def AN_INT(size: Int): Codec[Int] =
    AN(size).xmap(Integer.parseInt, _.toString)

  def TVL(
      tagCodec: Codec[String],
      lengthCodec: Codec[Int],
      valueCodec: Codec[String]
  ): Codec[(String, String)] = {
    tagCodec
      .flatZip(_ => variableSizeBytes(lengthCodec, valueCodec))
      .as[(String, String)]
  }

  def LLVAR[A](codec: Codec[A]): Codec[A] = variableSizeBytes(int8, codec)
  def LLVAR_N[A](codec: Codec[A]): Codec[A] = variableSizeBytes(int8.xmap(_ / 2, _ * 2), codec)
  def LLLVAR[A](codec: Codec[A]): Codec[A] = variableSizeBytes(int16, codec)
}
