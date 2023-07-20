import DashboardLayout from '@/Layouts/DashboardLayout';
import { Head } from "@inertiajs/react";

export default function Dashboard({ auth, user }) {
    
    return (
        <>
            <div className="flex flex-col">
                <DashboardLayout
                    user={auth.user}
                    header={<h1 className="text-2xl text-black font-medium">Dashboard</h1>}
                >
                </DashboardLayout>

            </div>

        
        </>

    );
}
