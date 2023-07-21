import AuthenticatedLayout from "@/Layouts/AuthenticatedLayout";
import DashboardLayout from "@/Layouts/DashboardLayout";
import { Inertia } from "@inertiajs/inertia";
import { Head } from "@inertiajs/react";
import { handler } from "daisyui";
import { useState } from "react";

export default function Event({ auth, props }) {
    const [name, setName] = useState("");
    const [uraian, setUraian] = useState("");
    const [tujuan, setTujuan] = useState("");
    const [tanggal, setTanggal] = useState("");
    const [waktu, setWaktu] = useState("");
    const [isNotif, setIsNotif] = useState(false);

    const handleSubmit = () => {
        const data = {
            name,
            uraian,
            tujuan,
            tanggal,
            waktu,
        };
        Inertia.post("/event/post", data);
        setIsNotif(true);
        setName("");
        setUraian("");
        setTujuan("");
        setTanggal("");
        setWaktu("");

        setTimeout(() => {
            setIsNotif(false);
        }, 2000);
    };
    

    // console.log(props);
    return (
        <div className="bg-[#EBDFD7] flex">
            <DashboardLayout user={auth.user} />
            <Head title="Dashboard" />

            <div className="flex flex-col w-full">
                <div className="px-5 py-6 border-b-2 border-gray-300 max-h-[6rem] w-full">
                    <h1 className="text-3xl text-black font-medium ">Event</h1>
                </div>
                <div className="mx-5 my-5 h-screen rounded-xl bg-white/40">
                    {isNotif && (
                        <div className="px-4 py-4">
                            <div className="alert alert-success">
                                <svg
                                    xmlns="http://www.w3.org/2000/svg"
                                    className="stroke-current shrink-0 h-6 w-6"
                                    fill="none"
                                    viewBox="0 0 24 24"
                                >
                                    <path
                                        strokeLinecap="round"
                                        strokeLinejoin="round"
                                        strokeWidth="2"
                                        d="M9 12l2 2 4-4m6 2a9 9 0 11-18 0 9 9 0 0118 0z"
                                    />
                                </svg>
                                <span>Event added successfully!</span>
                            </div>
                        </div>
                    )}

                    {/* Open the modal using ID.showModal() method */}
                    <div className="px-4 py-5">
                        <button
                            className="btn bg-[#E65F2B] text-white border-none"
                            onClick={() => window.my_modal_2.showModal()}
                        >
                            open modal
                        </button>
                        <dialog id="my_modal_2" className="modal">
                            <form
                                method="dialog"
                                className="modal-box  bg-white"
                            >
                                <h3 className="font-bold text-lg">Hello!</h3>
                                <p className="py-4">
                                    <input
                                        type="text"
                                        placeholder="Name Event"
                                        onChange={(name) =>
                                            setName(name.target.value)
                                        }
                                        value={name}
                                        className="input w-full mt-4 input-bordered bg-white md:"
                                    />
                                    <input
                                        type="text"
                                        placeholder="Uraian"
                                        onChange={(uraian) =>
                                            setUraian(uraian.target.value)
                                        }
                                        value={uraian}
                                        className="input w-full mt-4 input-bordered bg-white md:"
                                    />
                                    <input
                                        type="text"
                                        placeholder="Tujuan"
                                        onChange={(tujuan) =>
                                            setTujuan(tujuan.target.value)
                                        }
                                        value={tujuan}
                                        className="input w-full mt-4 input-bordered bg-white"
                                    />
                                    <input
                                        type="date"
                                        placeholder="Tanggal"
                                        onChange={(tanggal) =>
                                            setTanggal(tanggal.target.value)
                                        }
                                        value={tanggal}
                                        className="input w-full mt-4 input-bordered bg-white"
                                    />
                                    <input
                                        type="time"
                                        placeholder="Time"
                                        onChange={(waktu) =>
                                            setWaktu(waktu.target.value)
                                        }
                                        value={waktu}
                                        className="input w-full mt-4 input-bordered bg-white"
                                    />
                                    <button
                                        className="btn bg-[#E65F2B] text-white border-none mt-5"
                                        onClick={() => handleSubmit()}
                                    >
                                        Submit
                                    </button>
                                </p>
                            </form>
                            <form method="dialog" className="modal-backdrop">
                                <button>close</button>
                            </form>
                        </dialog>
                    </div>
                </div>
            </div>
        </div>
        // <DashboardLayout
        //     className="pt-1 flex flex-col"
        //     user={auth.user}
        //     header={<h1 className="text-2xl text-black font-medium">Event</h1>}
        // >
        //     <Head title="Event" />

        //     <div className="pt-3 pl-10">
        //         <div className="sm:px-6 lg:px-8">
        //             <div className="p-20 bg-white border-b border-gray-200 overflow-hidden sm:rounded-lg">
        //                 {isNotif && (
        //                     <div className="alert alert-success">
        //                         <svg
        //                             xmlns="http://www.w3.org/2000/svg"
        //                             className="stroke-current shrink-0 h-6 w-6"
        //                             fill="none"
        //                             viewBox="0 0 24 24"
        //                         >
        //                             <path
        //                                 strokeLinecap="round"
        //                                 strokeLinejoin="round"
        //                                 strokeWidth="2"
        //                                 d="M9 12l2 2 4-4m6 2a9 9 0 11-18 0 9 9 0 0118 0z"
        //                             />
        //                         </svg>
        //                         <span>Event added successfully!</span>
        //                     </div>
        //                 )}
        //                 <input
        //                     type="text"
        //                     placeholder="Uraian"
        //                     onChange={(uraian) =>
        //                         setUraian(uraian.target.value)
        //                     }
        //                     value={uraian}
        //                     className="input w-full mt-4 input-bordered bg-white md:"
        //                 />
        //                 <input
        //                     type="text"
        //                     placeholder="Tujuan"
        //                     onChange={(tujuan) =>
        //                         setTujuan(tujuan.target.value)
        //                     }
        //                     value={tujuan}
        //                     className="input w-full mt-4 input-bordered bg-white"
        //                 />
        //                 <input
        //                     type="date"
        //                     placeholder="Tanggal"
        //                     onChange={(tanggal) =>
        //                         setTanggal(tanggal.target.value)
        //                     }
        //                     value={tanggal}
        //                     className="input w-full mt-4 input-bordered bg-white"
        //                 />
        //                 <input
        //                     type="time"
        //                     placeholder="Time"
        //                     onChange={(waktu) => setWaktu(waktu.target.value)}
        //                     value={waktu}
        //                     className="input w-full mt-4 input-bordered bg-white"
        //                 />
        //                 <button
        //                     className="btn bbt-success mt-10 "
        //                     onClick={() => handleSubmit()}
        //                 >
        //                     Submit
        //                 </button>
        //             </div>
        //         </div>
        //     </div>
        // </DashboardLayout>
    );
}
