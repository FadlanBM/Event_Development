import { Link, router } from "@inertiajs/react";
import Ornament from "../assets/Ornament.svg";
import home from "../assets/home.png";
import Assets from "../assets/Assets.png";
import NatashaSunny from "@/Components/NatashaSunny";

export default function Home() {
    return (
        <>
            <div className="flex py-[7rem] px-[5rem] xl:px-[14rem] bg-[#0F1017]">
                <div className="pt-[3rem]">
                    <h1 className="xl:text-[6rem] text-[4rem] leading-[4.7rem] text-white font-semibold">
                        Reliable, secure
                        <img className="inline align-top" src={Ornament} />
                        <br />
                        conference to get
                        <br />
                        the best events
                    </h1>
                    <p className="text-[#CFCFD1] mt-[2rem] text-[17px]">
                        Hold incredible events, share knowledge, build and grow
                        your
                        <br />
                        product , create opportunity
                    </p>
                    <Link href="/join">
                        <button className="w-[198px] h-[50px] mt-9 text-white font-medium rounded-md bg-[#E14817]">
                            Join A Meeting
                        </button>
                    </Link>
                </div>

                <div>
                    <img className="ml-[4.5rem]" src={home} />
                </div>
            </div>

            <div className="bg-[#F8F8F8] h-[589px] flex justify-center items-center">
                <div className="flex items-center gap-x-[3.8rem]">
                    <div>
                        <img src={Assets} />
                    </div>

                    <div>
                        <h1 className="text-[2.7rem] text-black font-semibold leading-[58px]">
                            Everyone on their
                            <br />
                            own device.
                        </h1>
                        <p className="text-[#57585D] mt-[15px] leading-8 tracking-wider text-[17px]">
                            <span className="font-semibold">EventUp</span> is
                            designed to be inclusive, by being
                            <br />
                            able to use your own device to help hybrid-
                            <br />
                            conference teams create, collaborate and
                            <br />
                            celebrate together.
                        </p>
                    </div>
                </div>
            </div>

            <div className="bg-white h-[1066px]">
                <NatashaSunny />
            </div>
        </>
    );
}
